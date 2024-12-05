package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (chessBoard == null || chessBoard.isLegalBoardPosition(newX, newY)) {
            throw new UnsupportedOperationException("Invalid move");
        }

        if (movementType == MovementType.MOVE) {
            if (PieceColor.BLACK.equals(pieceColor) && xCoordinate == newX && yCoordinate - 1 == newY) {
                xCoordinate = newX;
                yCoordinate = newY;
            }
            else if (PieceColor.WHITE.equals(pieceColor) && xCoordinate == newX && yCoordinate + 1 == newY) {
                xCoordinate = newX;
                yCoordinate = newY;
            }
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
