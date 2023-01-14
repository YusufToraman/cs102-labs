package Lab2;

public class Verb {
    private String [] verbForms;

    public Verb(String form0, String form1, String form2, String form3, String form4){
        verbForms = new String[5];
        verbForms[0] = form0;
        verbForms[1] = form1;
        verbForms[2] = form2;
        verbForms[3] = form3;
        verbForms[4] = form4; 
    }

    public boolean check(String word){
        if(word.equalsIgnoreCase(verbForms[0])||word.equalsIgnoreCase(verbForms[1])||word.equalsIgnoreCase(verbForms[1])||word.equalsIgnoreCase(verbForms[2])||word.equalsIgnoreCase(verbForms[3])||word.equalsIgnoreCase(verbForms[4])){
            return true;
        }
        return false;
    }

    public String[] getVerbForms(){
        return verbForms;
    }
}
