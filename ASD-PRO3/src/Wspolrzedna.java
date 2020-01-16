import java.util.Objects;

public class Wspolrzedna {
    int x;
    int y;

    public Wspolrzedna(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ","+ y + ')'; // (x,y)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wspolrzedna that = (Wspolrzedna) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
