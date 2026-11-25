package Service;

import Entity.BookEntity;
import Entity.MemberEntity;
import Model.MemberDTO;

public interface AddMemberService {

    boolean addMemberDetails(MemberDTO memberDTO);
    boolean updateMemberDetails(MemberDTO memberDTO);
    MemberEntity searchMemberDetails(Integer id);
    boolean deletememberDetails(Integer id);
}
