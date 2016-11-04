public class JsonEncoderImpl implements api.week1.JsonEncoder {
  
  public String toJson( String str ) {
    return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
  }
  
  public String toJson( Number n ) {
    return n.doubleValue() + "";
  }
  
  public String toJson( java.util.Map map ) {
    String ret = "{";
    boolean first = true;
    for( Object key : map.keySet() ) {
      if ( !first ) ret += ",";
      else first = false;

      String valueStr = "";
      if(map.get(key) instanceof String) {
        String value = (String) map.get(key);
        valueStr = toJson(value);
      } else if(map.get(key) instanceof Number || map.get(key) instanceof Integer || map.get(key) instanceof Float || map.get(key) instanceof Double) {
        Number value = (Number) map.get(key);
        valueStr = toJson(value);
      }

      ret += toJson((String)key) + ": " + valueStr;
    }
    return ret + "}";
  }
  
  public static void main(String args[]) {
    JsonEncoderImpl enc = new JsonEncoderImpl();
    System.out.println( enc.toJson(12d) );
  }
}