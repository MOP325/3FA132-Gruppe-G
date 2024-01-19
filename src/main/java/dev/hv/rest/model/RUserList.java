package dev.hv.rest.model;

import java.util.ArrayList;
import java.util.Collection;

public class RUserList extends ArrayList<IRUser> {

   public RUserList() {
      super();
   }

   public RUserList(final Collection<? extends RUser> u) { 
      super(u);
   }

   public RUserList(final int initialCapacity) {
      super(initialCapacity);
   }
}