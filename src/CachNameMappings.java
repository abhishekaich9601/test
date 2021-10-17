import objects.OrganizationalUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CachNameMappings {

    private Map<String, Function> functionHashMap = new HashMap<>();

    public CachNameMappings() {
        functionHashMap.put("OU", o -> ((OrganizationalUnit)o).getCode());
    }

    public Map<String, Function> getFunctionHashMap() {
        return functionHashMap;
    }

    public static void main(String[] args) {
        OrganizationalUnit ou = new OrganizationalUnit();
        ou.setCode("OU001");
        CachNameMappings cachNameMappings = new CachNameMappings();
        String finalValue = (String)cachNameMappings.getFunctionHashMap().get("OU").apply(ou);
        System.out.println(finalValue);
        ou.setCode("OU002");
        finalValue = (String)Constants.CacheName.OU.getFunction().apply(ou);
        System.out.println("Second way output:"+finalValue);

    }


}
