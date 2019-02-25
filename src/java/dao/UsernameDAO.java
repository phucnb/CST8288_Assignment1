package dao;

import entity.Username;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shariar Emami
 * @since Jan 14, 2019
 */
public class UsernameDAO extends GenericDAO<Username> {

    public UsernameDAO() {
        super(Username.class);
    }
    
    public List<Username> findAll(){
        return findResults( "Username.findAll", null);
    }
    
    public List<Username>  findByPlayerID( int playerID){
        Map<String, Object> map = new HashMap<>();
        map.put("playerid", playerID);
        return findResults( "Username.findByPlayerid", map);
    }
    
    public List<Username> findByUsername( String username){
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return findResults( "Username.findByUsername", map);
    }
    
//    public List<Username> findByContainKeywordInUsername( String username){
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", username);
//        return findResults( "Username.findByContainKeywordInUsername", map);
//    }
//    
//    public List<Username> findByContainKeywordPlayerid( int playerID){
//        Map<String, Object> map = new HashMap<>();
//        map.put("playerid", String.valueOf(playerID));
//        System.out.println("ok111");
//        System.out.println(String.valueOf("%"+playerID+"%"));
//        return findResults( "Username.findByContainKeywordPlayerid", map);
//    }
}
