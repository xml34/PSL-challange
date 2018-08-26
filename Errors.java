public class Errors{
    public boolean sizeSintaxCheck(String[] in){
        if(in.length==3){
            try{
                Integer.parseInt(in[0]);
                Integer.parseInt(in[1]);
                Integer.parseInt(in[2]);
                return true;
            } catch (NumberFormatException excepcion) {
                System.out.println("incorrect input, check sintax");
                return false;
            }
        }
        System.out.println("Incorret number of arguments");
        return false;
    }
    public boolean sizeLogicCheck(String[] in){
        int i = Integer.parseInt(in[0]);
        int j= Integer.parseInt(in[1]);
        int k = Integer.parseInt(in[2]);
        if(i<0 || j<0 || k<0 || k>i*j){
            System.out.println("invalid input, out of bounds, or too much mines");
            return false;
        }
        return true;
    }
    public boolean inputSintaxCheck(String[] in){
        if(in.length==3){
            try{
                Integer.parseInt(in[0]);
                Integer.parseInt(in[1]);
                if(in[2].equals("M") || in[2].equals("U")){
                    return true;
                }
                System.out.println("incorrect input, check sintax");
                return false;
            } catch (NumberFormatException excepcion) {
                System.out.println("incorrect input, check sintax");
                return false;
            }
        }
        System.out.println("Incorret number of arguments");
        return false;
    }
    public boolean inputLogicCheck(String[] in,int heigh,int width){
        try{           
            int i=Integer.parseInt(in[0]);
            int j=Integer.parseInt(in[1]);
            if(i<0 || j<0 || i>=heigh || j>=width){
                System.out.println("invalid input, out of bounds");
                return false;
            }
        }
        catch (NumberFormatException excepcion) {
            return false;
        }       
        return true;
    }
}