package api;

public enum Commands {
    //Enum of command lists of app
    LIST("list"), ADD("add"), SUMMARY("summary"), DELETE("delete"), HELP("help"), EDIT("edit");
    final String label;
    Commands(String label){
                this.label = label;
    }
    public String getCommandName(){
        return this.label;
    }
}
