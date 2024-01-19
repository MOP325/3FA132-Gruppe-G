package dev.hv.rest.model;

import java.util.ArrayList;
import java.util.Collection;

public class RReadingList extends ArrayList<IRReading> {

    public RReadingList() {
        super();
    }

    public RReadingList(final Collection<? extends RReading> r) {
      super((Collection<? extends IRReading>) r);
   }

    public RReadingList(final int initialCapacity) {
        super(initialCapacity);
    }
}
