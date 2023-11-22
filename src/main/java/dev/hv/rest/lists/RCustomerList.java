package dev.hv.rest.lists;

import java.util.ArrayList;
import java.util.Collection;
import dev.hv.rest.model.IRCustomer;
import dev.hv.rest.model.RCustomer;

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