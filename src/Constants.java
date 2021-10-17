import objects.OrganizationalUnit;

import java.util.function.Function;

public class Constants {



    public enum CacheName {
        OU(o -> ((OrganizationalUnit)o).getCode());

        private Function function;

        CacheName(Function function) {
            this.function = function;
        }

        public Function getFunction() {
            return function;
        }
    }

}
