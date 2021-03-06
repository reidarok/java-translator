package no.freecode.translator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class MessageSection {

	@Id
	private String id;
	
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @ElementCollection(fetch = FetchType.EAGER)
//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("property")
    private Set<Message> messages = new HashSet<Message>();

    public static List<MessageSection> findAllMessageSectionsSorted() {
        return entityManager().createQuery("select o from MessageSection o order by description", MessageSection.class).getResultList();
    }

}
