package FileParse;

/**
 * @author Victor Velechovsky
 * @version 1.0
 */
public class Element implements Comparable<Element> {

    String [] lines;
    String state;

    public Element (String [] lines) {
        this.lines = lines;

        state = lines[63];
    }

    @Override
    public int compareTo(Element o) {

        Integer thisState = Integer.parseInt(state);
        Integer thatState = Integer.parseInt(o.state);

        return thisState.compareTo(thatState);

    }

    public String[] getLines() { return lines; }

}
