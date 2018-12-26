package cl.usach.dminute.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoOauth {
	
	private String name;
	private String given_name;
	private String family_name;
	private String email;
	private boolean email_verified;

}
