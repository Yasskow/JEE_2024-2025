package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Return implements Insurance{

    private boolean onlyMembers;
//    public Return(){
//        this.onlyMembers = false;
//    }

    public Return(@Value("${onlineshop.returninsurance.membersonly}") boolean forMembers) {
        this.onlyMembers = forMembers;
    }
    @Override
    public String description() {
        return onlyMembers ? "Return insurance only for members" : "Return insurance" ;
    }
}
