package member.repository

import member.entity.MemberEntity
import member.entity.Member
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class MemberRepository {
    fun save(user: MemberEntity) {
        transaction {
            Member.insert {
                it[id] = user.id
                it[name] = user.name
                it[email] = user.email
                it[role] = user.role
                it[status] = user.status
                it[profileImage] = user.profileImage
                it[phone] = user.phone
                it[created_at] = LocalDateTime.now();
            }
        }
    }

    private fun rowToMember(memberEntity: ResultRow): MemberEntity {
        return MemberEntity(
            id = memberEntity[Member.id],
            name = memberEntity[Member.name],
            email = memberEntity[Member.email],
            phone = memberEntity[Member.phone],
            role = memberEntity[Member.role],
            status = memberEntity[Member.status],
            profileImage = memberEntity[Member.profileImage]
        )
    }
}