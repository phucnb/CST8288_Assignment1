package dao;

import entity.Score;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author baphucnguyen
 */
public class ScoreDAO extends GenericDAO<Score>{
    
    public ScoreDAO(){
        super(Score.class);
    }
    
        public List<Score> findAll(){
        return findResults( "Score.findAll", null);
    }
    
    public List<Score>  findByID( int id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResults( "Score.findById", map);
    }
    
    public List<Score> findByScore( int score){
        Map<String, Object> map = new HashMap<>();
        map.put("score", score);
        return findResults( "Score.findByScore", map);
    }
    
    public List<Score> findBySubmission( Date submission){
        Map<String, Object> map = new HashMap<>();
        map.put("submission", submission);
        return findResults( "Score.findBySubmission", map);
    }
    
    public List<Score>  findByPlayerID( int playerID){
        Map<String, Object> map = new HashMap<>();
        map.put("playerid", playerID);
        return findResults( "Score.findByPlayerid", map);
    }
}
