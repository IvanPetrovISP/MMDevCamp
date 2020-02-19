public class MentorMateLogo {
    private static final char FILL_CHARACTER = '*';
    private static final char BACKGROUND_CHARACTER = '-';
    private int size;
    private int rows;
    private int cols;
    private char[][] matrix;

    public MentorMateLogo(int size) {
        this.size = size;
        this.setRows();
        this.setCols();
        this.matrix = new char[rows][cols];
        fillMatrix();
    }

    private void setRows() {
        this.rows = size + 1;
    }

    private void setCols() {
        this.cols = size * 5;
    }

    private void fillMatrix() {
        fillMatrixBackground();
        fillMatrixWithLetterM();
    }

    private void fillMatrixBackground() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.matrix[i][j] = BACKGROUND_CHARACTER;
            }
        }
    }

    private void fillMatrixWithLetterM() {
        int leftOffset = size;
        int rightOffset = size;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < rows; j++) {

                this.matrix[j][leftOffset + i] = FILL_CHARACTER;
                this.matrix[j][size * 2 + leftOffset + i] = FILL_CHARACTER;
                leftOffset--;

                this.matrix[j][rightOffset + i] = FILL_CHARACTER;
                this.matrix[j][size * 2 + rightOffset + i] = FILL_CHARACTER;
                rightOffset++;

            }

            leftOffset = size;
            rightOffset = size;
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.append(this.matrix[i][j]);
            }
            for (int j = 0; j < this.cols; j++) {
                result.append(this.matrix[i][j]);
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }
}
