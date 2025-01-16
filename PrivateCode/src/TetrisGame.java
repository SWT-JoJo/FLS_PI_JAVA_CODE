
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisGame extends JFrame {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;
    private final int BLOCK_SIZE = 30;
    private final Timer timer;
    private boolean isPaused = false;

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
    private Tetromino currentTetromino;
    private int currentX, currentY;

    public TetrisGame() {
        setTitle("Tetris");
        setSize(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initGame();

        timer = new Timer(500, e -> {
            if (!isPaused) {
                moveDown();
            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isPaused) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> moveLeft();
                        case KeyEvent.VK_RIGHT -> moveRight();
                        case KeyEvent.VK_DOWN -> moveDown();
                        case KeyEvent.VK_UP -> rotate();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isPaused = !isPaused;
                }
            }
        });

        setVisible(true);
    }

    private void initGame() {
        clearBoard();
        spawnTetromino();
    }

    private void clearBoard() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = 0;
            }
        }
    }

    private void spawnTetromino() {
        currentTetromino = Tetromino.randomTetromino();
        currentX = BOARD_WIDTH / 2 - 1;
        currentY = 0;
        if (!canMove(currentTetromino.getShape(), currentX, currentY)) {
            gameOver();
        }
    }

    private void moveLeft() {
        if (canMove(currentTetromino.getShape(), currentX - 1, currentY)) {
            currentX--;
            repaint();
        }
    }

    private void moveRight() {
        if (canMove(currentTetromino.getShape(), currentX + 1, currentY)) {
            currentX++;
            repaint();
        }
    }

    private void moveDown() {
        if (canMove(currentTetromino.getShape(), currentX, currentY + 1)) {
            currentY++;
        } else {
            mergeTetromino();
            clearFullLines();
            spawnTetromino();
        }
        repaint();
    }

    private void rotate() {
        int[][] rotatedShape = currentTetromino.getRotatedShape();
        if (canMove(rotatedShape, currentX, currentY)) {
            currentTetromino.rotate();
            repaint();
        }
    }

    private boolean canMove(int[][] shape, int x, int y) {
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int newX = x + col;
                    int newY = y + row;
                    if (newX < 0 || newX >= BOARD_WIDTH || newY >= BOARD_HEIGHT || (newY >= 0 && board[newY][newX] != 0)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void mergeTetromino() {
        int[][] shape = currentTetromino.getShape();
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    board[currentY + row][currentX + col] = shape[row][col];
                }
            }
        }
    }

    private void clearFullLines() {
        for (int row = BOARD_HEIGHT - 1; row >= 0; row--) {
            boolean isFull = true;
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] == 0) {
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                removeLine(row);
                row++;
            }
        }
    }

    private void removeLine(int line) {
        for (int row = line; row > 0; row--) {
            System.arraycopy(board[row - 1], 0, board[row], 0, BOARD_WIDTH);
        }
        for (int col = 0; col < BOARD_WIDTH; col++) {
            board[0][col] = 0;
        }
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over!", "Tetris", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBoard(g);
        drawTetromino(g);
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] != 0) {
                    drawBlock(g, col * BLOCK_SIZE, row * BLOCK_SIZE, board[row][col]);
                }
            }
        }
    }

    private void drawTetromino(Graphics g) {
        int[][] shape = currentTetromino.getShape();
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    drawBlock(g, (currentX + col) * BLOCK_SIZE, (currentY + row) * BLOCK_SIZE, shape[row][col]);
                }
            }
        }
    }

    private void drawBlock(Graphics g, int x, int y, int color) {
        g.setColor(new Color(color));
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TetrisGame::new);
    }
}

class Tetromino {

    private int[][] shape;
    private final int color;

    public Tetromino(int[][] shape, int color) {
        this.shape = shape;
        this.color = color;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getColor() {
        return color;
    }

    public int[][] getRotatedShape() {
        int size = shape.length;
        int[][] rotated = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                rotated[col][size - row - 1] = shape[row][col];
            }
        }
        return rotated;
    }

    public void rotate() {
        shape = getRotatedShape();
    }

    public static Tetromino randomTetromino() {
        int[][][] shapes = {
            {{1, 1, 1, 1}}, // I
            {{2, 2}, {2, 2}}, // O
            {{0, 3, 0}, {3, 3, 3}}, // T
            {{4, 4, 0}, {0, 4, 4}}, // Z
            {{0, 5, 5}, {5, 5, 0}}, // S
            {{6, 6, 6}, {6, 0, 0}}, // L
            {{7, 7, 7}, {0, 0, 7}} // J
        };
        int color = (int) (Math.random() * 0xFFFFFF);
        int[][] shape = shapes[(int) (Math.random() * shapes.length)];
        return new Tetromino(shape, color);
    }
}
