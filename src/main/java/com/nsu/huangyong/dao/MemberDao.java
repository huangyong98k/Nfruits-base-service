package com.nsu.huangyong.dao;

import com.nsu.huangyong.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberDao extends JpaRepository<Member,Long>, JpaSpecificationExecutor<Member> {
    /**
     * 匹配手机号和密码
     */
    Member findMemberByPhoneNoAndLoginPassword(String phoneNo,String LoginPassword);

    /**
     * 根据手机号获取会员信息
     */
    Member findMemberByPhoneNo(String phoneNo);

    /**
     * 重置密码
     */
    @Query(value = "update member set login_password = ?1 where phone_no =?2",nativeQuery = true)
    @Modifying
    void resetPassword(String newPassword,String phoneNo);

    /**
     * 验证身份证是否已实名
     */
    Member findMemberByCertificateNo(String certificateNo);

    /**
     * 实名认证
     */
    @Query(value = "update member set true_name = ?2,certificate_type = ?3,certificate_no = ?4 where member_no =?1",nativeQuery = true)
    @Modifying
    void certification(String Member,String trueName, String certificateType, String certificateNo);

    /**
     * 更新基本信息
     */
    @Query(value = "update member set nickname = ?2,sex = ?3,birth_date = ?4 where member_no =?1",nativeQuery = true)
    @Modifying
    void updateMember(String memberNo, String nickname, String sex, String birthDate);
}
