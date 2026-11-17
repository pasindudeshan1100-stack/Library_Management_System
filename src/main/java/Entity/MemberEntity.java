package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private  Integer member_id;

    @Column(name = "full_name",nullable = false)
    private  String name;

    @Column (name = "email",nullable = false)
    private  String email;

    @Column (name = "phone_number",nullable = false)
    private String phone_number;

    @Column (name = "adress",nullable = false)
    private  String adress;

    public MemberEntity() {
    }

    public MemberEntity( String name, String email, String phone_number, String adress) {

        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.adress = adress;
    }

//    public Integer getMember_id() {
//        return member_id;
//    }
//
//    public void setMember_id(Integer member_id) {
//        this.member_id = member_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
