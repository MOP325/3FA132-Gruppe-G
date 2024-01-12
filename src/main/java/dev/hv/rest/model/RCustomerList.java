package dev.hv.rest.model;

import java.util.ArrayList;
import java.util.Collection;

public class RCustomerList extends ArrayList<IRCustomer> {

   public RCustomerList() {
      super();
   }

   public RCustomerList(final Collection<? extends RCustomer> c) { 

   }

   public RCustomerList(final int initialCapacity) {
      super(initialCapacity);
   }
}