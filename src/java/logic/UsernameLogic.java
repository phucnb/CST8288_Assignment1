package logic;

import dao.UsernameDAO;
import entity.Player;
import entity.Username;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shariar
 */
public class UsernameLogic extends GenericLogic<Username, UsernameDAO> {

    public static final String PLAYER_ID = "id";
    public static final String USERNAME = "username";

    public UsernameLogic() {
        super(new UsernameDAO());
    }

    public List<Username> getAll() {
        return get(() -> dao().findAll());
    }

    public List<Username> getByID(int playerID) {
        return get(() -> dao().findByPlayerID(playerID));
    }

    public List<Username> getByUserName(String username) {
        return get(() -> dao().findByUsername(username));
    }

//    public List<Username> getByContainKeywordInUserName(String username) {
//        return get(() -> dao().findByContainKeywordInUsername(username));
//    }
//    
//    public List<Username> getByContainKeywordInPlayerID(int playerID) {
//        return get(() -> dao().findByContainKeywordPlayerid(playerID));
//    }
    /**
     * Create an entity to add
     *
     * @param parameterMap
     * @return
     */
    @Override
    public Username createEntity(Map<String, String[]> parameterMap) {
        Username user = new Username();
        PlayerLogic playerLogic = new PlayerLogic();

        //check validation input first
        if (validation(parameterMap.get(PLAYER_ID)[0], 10, false)) {
            //get player base on the ID
            Player player = playerLogic.getPlayerWithId(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
            //set this player to Username Object
            user.setPlayer(player);
            //set PlayerId from input
            user.setPlayerid(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
            //ser username from input
            if (validation(parameterMap.get(USERNAME)[0], 50, false)) {
                try {

                    user.setUsername(parameterMap.get(USERNAME)[0]);
                } catch (Exception e) {
                }
            }
        }
        return user;
    }

    /**
     * to check the input is valid or not before create entity
     *
     * @param input : string to check, username or playerid
     * @param length : length allowed in DB
     * @param isNull : null able or not
     * @return
     */
    public boolean validation(String input, int length, boolean isNull) {

        if (!isNull) {
            if (input.equals("")) {
                return false;
            } else if (input.length() > length) {
                return false;
            }
        } else {
            if (!input.equals("")) {
                if (input.length() > length) {
                    return false;
                }
            }
        }
        return true;
    }

}
