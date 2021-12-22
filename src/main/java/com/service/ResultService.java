package com.service;

import com.dao.PointRepo;
import com.model.MatchModel;
import com.model.PointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Result service.
 */
@Service
public class ResultService {
    @Autowired
    private PointRepo pointRepo;

    /**
     * Get result match model.
     *
     * @param matchModel the match model
     * @return the match model
     */
    public MatchModel getResult(MatchModel matchModel){
        Long teamId1=matchModel.getTeam1().getId();
        Long teamId2=matchModel.getTeam2().getId();
        PointModel pointModel1= pointRepo.findByTeamId(teamId1);
        PointModel pointModel2= pointRepo.findByTeamId(teamId2);
        System.out.println(teamId1+"  "+teamId2);
        if(pointModel1==null) {
            pointModel1=new PointModel();
            pointModel1.setPoint(0);
            pointModel1.setWinCount(0);
            pointModel1.setLossCount(0);
            pointModel1.setMatchCount(0);
            pointModel1.setTeam(matchModel.getTeam1());
        }

        if(pointModel2==null) {
            pointModel2=new PointModel();
            pointModel2.setPoint(0);
            pointModel2.setWinCount(0);
            pointModel2.setLossCount(0);
            pointModel2.setMatchCount(0);
            pointModel2.setTeam(matchModel.getTeam2());
        }

        //

        String team1 =  matchModel.getTeam1Description();
        int team1Score = Integer.parseInt(team1);
        String wicket1 =  matchModel.getTeam1Wickets();
        int  team1wicket = Integer.parseInt(wicket1);
        String team2 = matchModel.getTeam2Description();
        int team2Score = Integer.parseInt(team2);
        String wicket2 = matchModel.getTeam2Wickets();
        int  team2wicket = Integer.parseInt(wicket2);
        Long team1overs= Long.valueOf((String.valueOf(matchModel.getTeam1Overs())));
        Long tema2overs= Long.valueOf( (String.valueOf(matchModel.getTeam2Overs())));
        System.out.println("===============--------------------------------------==============="+pointModel1.getMatchCount()+" "+pointModel2.getMatchCount());



        if(team1Score>team2Score){
            matchModel.setResult(matchModel.getTeam1().getTeamname()+" won by "+(team1Score-team2Score)+ " Runs");
            System.out.println(team1Score-team2Score+"++++++++++++++++++++++++++++++++__________________+");
            pointModel1.setWinCount(pointModel1.getWinCount()+1);
            pointModel2.setLossCount(pointModel2.getLossCount()+1);
            pointModel1.setPoint(pointModel1.getPoint()+2);
            pointModel1.setMatchCount(pointModel1.getMatchCount()+1);
            pointModel2.setMatchCount(pointModel2.getMatchCount()+1);


            System.out.println("===============--------------------------------------==============="+ matchModel.getResult());
        }

        else if(team2Score>team1Score){
            matchModel.setResult(matchModel.getTeam2().getTeamname() + " won by " + (11 - team2wicket)+ " wickets" );

            pointModel2.setWinCount(pointModel2.getWinCount()+1);
            pointModel1.setLossCount(pointModel1.getLossCount()+1);
            pointModel2.setPoint(pointModel2.getPoint()+2);
            pointModel1.setMatchCount(pointModel1.getMatchCount()+1);
            pointModel2.setMatchCount(pointModel2.getMatchCount()+1);

            System.out.println("===============-------------===========-------------------------==============="+ matchModel.getResult());
        }

        System.out.println(matchModel.getResult()+"----------------------------------------------------------------=========================================");
        pointRepo.save(pointModel1);
        pointRepo.save(pointModel2);

        return matchModel;
    }

    /**
     * Get point list.
     *
     * @return the list
     */
    public List<PointModel> getPoint(){
        List<PointModel> point= pointRepo.findAll();
        return point;
    }


}
