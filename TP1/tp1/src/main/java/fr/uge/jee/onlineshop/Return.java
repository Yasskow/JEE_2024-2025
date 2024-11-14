package fr.uge.jee.onlineshop;

public class Return implements Insurance{
    private final boolean onlyMembers;
    public Return(){
        this.onlyMembers = false;
    }

    public Return(boolean forMembers) {
        this.onlyMembers = forMembers;
    }
    @Override
    public String description() {
        return onlyMembers ? "Return insurance only for members" : "Return insurance" ;
    }
}
