package com.model;

public class JsonModel {
    private Long id;
    String result;
    private String  scheduledate;
    private String time;
    private String venue;
    private String team1Description;
    private String team2Description;

    private String team1Wickets;

    public String getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(String scheduledate) {
        this.scheduledate = scheduledate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTeam1Description() {
        return team1Description;
    }

    public void setTeam1Description(String team1Description) {
        this.team1Description = team1Description;
    }

    public String getTeam2Description() {
        return team2Description;
    }

    public void setTeam2Description(String team2Description) {
        this.team2Description = team2Description;
    }

    public String getTeam1Wickets() {
        return team1Wickets;
    }

    public void setTeam1Wickets(String team1Wickets) {
        this.team1Wickets = team1Wickets;
    }

    public String getTeam2Wickets() {
        return team2Wickets;
    }

    public void setTeam2Wickets(String team2Wickets) {
        this.team2Wickets = team2Wickets;
    }

    public Double getTeam1Overs() {
        return team1Overs;
    }

    public void setTeam1Overs(Double team1Overs) {
        this.team1Overs = team1Overs;
    }

    public Double getTeam2Overs() {
        return team2Overs;
    }

    public void setTeam2Overs(Double team2Overs) {
        this.team2Overs = team2Overs;
    }

    public String getStateModel() {
        return stateModel;
    }

    public void setStateModel(String stateModel) {
        this.stateModel = stateModel;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    private String team2Wickets;
    private Double team1Overs;

    private Double team2Overs;

    private String stateModel;
    private  String team1;

    private String team2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", scheduledate='" + scheduledate + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                ", team1Description='" + team1Description + '\'' +
                ", team2Description='" + team2Description + '\'' +
                ", team1Wickets='" + team1Wickets + '\'' +
                ", team2Wickets='" + team2Wickets + '\'' +
                ", team1Overs=" + team1Overs +
                ", team2Overs=" + team2Overs +
                ", stateModel='" + stateModel + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                '}';
    }
}
