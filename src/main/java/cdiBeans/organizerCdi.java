/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import entities.Organizermaster;
import entities.Projectusers;
import entities.Teammaster;
import entities.Teamownermaster;
import entities.Tournamenttb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.UploadedFile;

import restClient.organizerClient;
import restClient.teamClient;
import restClient.tournamentClient;

/**
 *
 * @author Bhatt Jaimin
 */
@Named(value = "organizercdi")
@SessionScoped
public class organizerCdi implements Serializable {

    /**
     * Creates a new instance of organizerCdi
     */
    //clients
    organizerClient client;
    tournamentClient tclient;
    teamClient teamclient;
    Teammaster team;
    Organizermaster organizer;
    Tournamenttb tournament;
    String Organizerid;
    String selectedOwnerId;
    Response rs;
    UploadedFile teamLogo;
    int selectedtournamentid ;
   
    GenericType<List<Tournamenttb>> glist = new GenericType<List<Tournamenttb>>() {
    };
    GenericType<List<Teamownermaster>> oglist = new GenericType<List<Teamownermaster>>() {
    };
    List<Teamownermaster> ownersList;

    public organizerCdi() {
        team = new Teammaster();
        client = new organizerClient();
        tclient = new tournamentClient();
        teamclient = new teamClient();
        organizer = new Organizermaster();
        tournament = new Tournamenttb();
        rs = client.getOwners(Response.class);
        ownersList = (List<Teamownermaster>) rs.readEntity(oglist);

    }

    public Teammaster getTeam() {
        return team;
    }

    public void setTeam(Teammaster team) {
        this.team = team;
    }

    public int getTournamentid() {
        return selectedtournamentid;
    }

    public void setTournamentid(int tournamentid) {
        this.selectedtournamentid = tournamentid;
    }
  

    public String getOrganizerid() {
        return Organizerid;
    }

    public UploadedFile getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(UploadedFile teamLogo) {
        this.teamLogo = teamLogo;
    }

    public void setOrganizerid(String Organizerid) {
        this.Organizerid = Organizerid;
    }

    public Tournamenttb getTournament() {
        return tournament;
    }

    public void setTournament(Tournamenttb tournament) {
        this.tournament = tournament;
    }

    public Organizermaster getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizermaster organizer) {
        this.organizer = organizer;
        this.Organizerid = organizer.getOrganizerId();
    }

    public List<Teamownermaster> getOwnersList() {
        return ownersList;
    }

    public void setOwnersList(List<Teamownermaster> ownersList) {
        this.ownersList = ownersList;
    }

    public String getSelectedOwnerId() {
        return selectedOwnerId;
    }

    public void setSelectedOwnerId(String selectedOwnerId) {
        this.selectedOwnerId = selectedOwnerId;
    }

    public Organizermaster getOrganizerDetails(String id) {

        organizer = client.getOrgenizer(Organizermaster.class, id);
        return organizer;
    }

    public String register() {
        try {
            client.OrgenizerRegistration(organizer);
            return "home.xhtml";
        } catch (Exception ex) {
            return "error.xhtml";
        }

    }

    public String createTournament() {
        try {
            Organizermaster org = new Organizermaster();
            org.setOrganizerId(Organizerid);
            tournament.setOrganizerId(org);
            tclient.addTournament(tournament);
            tournament = new Tournamenttb();
            return "viewTournaments.xhtml";
        } catch (Exception ex) {
            return "error.xhtml";
        }
    }

    public List<Tournamenttb> fetchAllTournaments() {
        rs = tclient.getAllTournaments(Response.class);
        List<Tournamenttb> tournamnetlist = rs.readEntity(glist);
        return tournamnetlist;
    }

    public String addNewTeam() {
        try {
            this.upload();
            Tournamenttb tr = new Tournamenttb();
            tr.setTournamentId(selectedtournamentid);
            team.setTournamentid(tr);
            Teamownermaster t1 = new Teamownermaster();
            t1.setOwnerId(selectedOwnerId);
            team.setOwnerId(t1);
            teamclient.addTeam(team);
            return "viewTeams.xhtml";
        } catch (Exception ex) {
            return "error.xhtml";
        }
    }

    public void upload() throws IOException {
        if (teamLogo != null) {
            FacesMessage message = new FacesMessage("Successful", teamLogo.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            //read input as stream of data from file
            InputStream inputStream = teamLogo.getInputstream();

            // create output stream of byte tyep
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            //read input stream and write into byte output stream 
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            // now insert into player.setPhoto()
            team.setTeamLogo(outputStream.toByteArray());

        }
    }

}
