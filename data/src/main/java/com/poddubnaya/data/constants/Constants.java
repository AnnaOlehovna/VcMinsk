package com.poddubnaya.data.constants;


public class Constants {

    private static Constants instance;

    public static Constants getInstance(){
        if(instance==null){
            return new Constants();
        }else return instance;
    }

    public final static String MINCHANKA = "MINCHANKA";
    public final static String MINCHANKA_PLAYERS_URL ="data/MinchankaPlayers";
    public final static String MINCHANKA_STAFF_URL ="data/MinchankaStaff";

    public final static String STROITEL = "STROITEL";
    public final static String STROITEL_PLAYERS_URL ="data/StroitelPlayers";
    public final static String STROITEL_STAFF_URL ="data/StroitelStaff";


}
