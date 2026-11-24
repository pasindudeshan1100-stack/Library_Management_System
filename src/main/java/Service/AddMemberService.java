package Service;

import Entity.BookEntity;
import Model.MemberDTO;

public interface AddMemberService {

    boolean addMemberDetails(MemberDTO memberDTO);
    boolean updateMemberDetails(MemberDTO memberDTO);
    BookEntity searchMemberDetails(Integer id);
    boolean deletememberDetails(Integer id);

}
