package dao;

import entity.Player;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author baphucnguyen
 */
public class PlayerDAO extends GenericDAO<Player> {

    public PlayerDAO() {
        super(Player.class);
    }

    public List<Player> findAll() {
        return findResults("Player.findAll", null);
    }

    public Player findById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult("Player.findById", map);
    }

    public List<Player> findByFirstName(String firstName) {
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", firstName);
        return findResults("Player.findByFirstName", map);
    }

    public List<Player> findByLastName(String lastName) {
          Map<String, Object> map = new HashMap<>();
        map.put("lastName", lastName);
        return findResults("Player.findByLastName", map);
    }

    public List<Player> findByJoined(Date date) {
         Map<String, Object> map = new HashMap<>();
        map.put("joined", date);
        return findResults("Player.findByJoined", map);
    }

     public List<Player> findByJoinedBeforeDate( Date date){
        Map<String, Object> map = new HashMap<>();
        map.put("joined", date);
        return findResults( "Player.findByJoinedBeforeDate", map);
    }
    public List<Player> findByJoinedAfterDate( Date date){
        Map<String, Object> map = new HashMap<>();
        map.put("joined", date);
        return findResults( "Player.findByJoinedAfterDate", map);
    }
    
    public Player findByEmail(String email) {
         Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        return findResult("Player.findByEmail", map);
    }

}
