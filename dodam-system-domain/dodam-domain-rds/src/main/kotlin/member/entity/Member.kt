package member.entity

import member.enumeration.ActiveStatus
import member.enumeration.MemberRole
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Member: Table() {
    val id: Column<Int> = integer("id").autoIncrement()

    val name: Column<String> = varchar("name", 50)

    val email: Column<String> = varchar("email", 50)

    val role: Column<MemberRole> = enumerationByName("role", 30, MemberRole::class)

    val status: Column<ActiveStatus> = enumerationByName("status", 30, ActiveStatus::class)

    val profileImage: Column<String> = text("profile_image")

    val phone: Column<String> = varchar("phone", 17)

    val created_at: Column<LocalDateTime> = datetime("created_at");

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

data class MemberEntity(
    val id: Int,
    val name: String,
    val email: String,
    val role: MemberRole,
    val status: ActiveStatus,
    val profileImage: String,
    val phone: String
)