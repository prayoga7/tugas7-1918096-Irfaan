package com.example.listfavoritefootballclubapp;

public class Football {
    private String _id, _club, _juara, _liga;

    public Football(String id, String club, String juara, String liga){
        this._id = id;
        this._club = club;
        this._juara = juara;
        this._liga = liga;
    }

    public Football(){}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_club() {
        return _club;
    }

    public void set_club(String _club) {
        this._club = _club;
    }

    public String get_juara() {
        return _juara;
    }

    public void set_juara(String _juara) {
        this._juara = _juara;
    }

    public String get_liga() {
        return _liga;
    }

    public void set_liga(String _liga) {this._liga = _liga;
    }
}
