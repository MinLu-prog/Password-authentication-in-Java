package Login;
import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords(){
		logininfo = new HashMap<>();
	}

	public void addUser(String userID, String password){
		logininfo.put(userID, password);
	}

	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}