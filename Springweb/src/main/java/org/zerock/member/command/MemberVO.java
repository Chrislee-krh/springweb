package org.zerock.member.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
}
