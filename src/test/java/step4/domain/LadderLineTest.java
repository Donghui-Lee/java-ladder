package step4.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    @Test
    public void move() {
        // given
        Point first = Point.first(true);
        Point next = first.next(false);
        Point last = next.next(false);
        List<Point> points = Arrays.asList(first, next, last);
        LadderLine ladderLine = new LadderLine(points);
        // when & then
        assertThat(ladderLine.move(0)).isEqualTo(1);
        assertThat(ladderLine.move(1)).isEqualTo(0);
        assertThat(ladderLine.move(2)).isEqualTo(2);
    }
}