import java.util.ArrayList;
import java.util.List;

public class Snake implements Element {
    List<Position> snakeBody = new ArrayList<>();
    private final String snakeElement = "s";

    private Direction headDirection = Direction.Right;

    public Snake(final Board board) {
        snakeBody.add(
                new Position(
                        RandomNumberGenerator.generate(board.getHeight()),
                        RandomNumberGenerator.generate(board.getWidth()),
                        snakeElement));
    }


    void increaseSize() {
        snakeBody.add(this.getNextPosition());
    }

    List<Position> getPosition() {
        return snakeBody;
    }

    public Position getHead() {
        return snakeBody.get(snakeBody.size() - 1);
    }

    public void setHeadDirection(Direction inputKey) {
        this.headDirection = inputKey;
    }

    Position getNextPosition() {

        Position nextPosition;
        Position head = this.getHead();

        if (headDirection == Direction.Up) {
            nextPosition = new Position(head.getXCoordinate() - 1, head.getYCoordinate(), snakeElement);

        } else if (headDirection == Direction.Right) {
            nextPosition = new Position(head.getXCoordinate(), head.getYCoordinate() + 1, snakeElement);

        } else if (headDirection == Direction.Down) {
            nextPosition = new Position(head.getXCoordinate() + 1, head.getYCoordinate(), snakeElement);

        } else {
            nextPosition = new Position(head.getXCoordinate(), head.getYCoordinate() - 1, snakeElement);
        }

        return nextPosition;
    }

    void setHeadDirectionToUp() {
        headDirection = Direction.Up;
    }

    void setHeadDirectionToRight() {
        headDirection = Direction.Right;
    }

    void setHeadDirectionToDown() {
        headDirection = Direction.Down;
    }

    void setHeadDirectionToLeft() {
        headDirection = Direction.Left;
    }


    void moveSnake() {
        snakeBody.add(this.getNextPosition());
        snakeBody.remove(0);
    }

    public boolean collidingWithWall(Board board){
        if((this.getHead().getXCoordinate() == board.getHeight() ||
                this.getHead().getXCoordinate() == board.getWidth() ||
                this.getHead().getYCoordinate() == board.getHeight() ||
                this.getHead().getYCoordinate() == board.getWidth())) {
            return true;
        }
        return false;
    }

    public List<Position> getPositionDetails() {
        return (new ArrayList<>(snakeBody));
    }

    public void print() {
        System.out.println("Snake Position: ");
        for (Position x : snakeBody) {
            System.out.println( x.getYCoordinate() + "," + x.getYCoordinate());
        }
    }

    public void eatApple()  {

    }

}
