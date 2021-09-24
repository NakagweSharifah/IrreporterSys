package com.irreporter.views;



import com.irreporter.models.Incident;
import com.irreporter.service.IncidentService;
import com.irreporter.service.IncidentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean(name = "incidentsView")
@SessionScoped
public class IncidentsView {

    
    private IncidentService serv = new IncidentServiceImpl();

    private Incident incident = new Incident();
    private List<Incident> incts;

    @PostConstruct
    public void init() {
        System.out.println("Initialising incident view bean...");
        this. serv = new IncidentServiceImpl();
        this.incts = fetchIncident();
        this.incident = new Incident();

    }

    private List<Incident> fetchIncident() {

        return serv.getAllIncidents() ;
    }

    public IncidentService getServ() {
        return serv;
    }

    public void setServ(IncidentService serv) {
        this.serv = serv;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public List<Incident> getIncts() {
        return incts;
    }

    public void setIncts(List<Incident> incts) {
        this.incts = incts;
    }


    public void saveIncident(Incident incident) throws Exception {
        System.out.println("Calling save");
      
        serv.saveIncident(incident);
    }

    
    public  Incident updateIncident(Incident incident) {
        System.out.println("Calling updateIncident");

        try {
            serv.updateIncident(incident);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incident;
    }

  
    public List<Incident> getAllIncidents() {
        System.out.println("Calling get  employees");

        return serv.getAllIncidents();
    }

    public List<Incident> getRedflagIncidents() {
        return serv.getRedflagIncidents();
    }
    public List<Incident> getInterventionIncidents() {
        return serv.getInterventionIncidents();
    }
}

