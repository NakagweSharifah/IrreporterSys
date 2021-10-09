package com.irreporter.views;

import com.irreporter.models.Incident;
import com.irreporter.models.enums.Type;
import com.irreporter.service.IncidentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean( name = "incidentsView" )
@SessionScoped
public class IncidentView {
        private IncidentServiceImpl serviceHelper =new IncidentServiceImpl();
        private Incident incident = new Incident();
        private List<Incident> redflagIncidents;
        private List<Incident> interventionIncidents;
        private List<Incident> incidents;
        private List<Type> types;



        @PostConstruct
        public void init() {


            this.serviceHelper = new IncidentServiceImpl();
            this.incidents = fetchIncidents();
            this.redflagIncidents = fetchRedflagIncidents();
            this.interventionIncidents = fetchInterventionIncidents();
            this.types= Arrays.asList(Type.values());
            this.incident = new Incident();

        }


        public List<Incident> fetchIncidents() {
            System.out.println("Calling getAllIncidents");
            return serviceHelper.getAllIncidents();
        }

        public List<Incident> fetchRedflagIncidents() {
            System.out.println("Calling getRedflagIncidents");
            return serviceHelper.getRedflagIncidents();
        }

        public List<Incident> fetchInterventionIncidents() {
            System.out.println("Calling getInterventionIncidents");
            return serviceHelper.getInterventionIncidents();
        }

        public List<Incident> save(Incident incident) {
            System.out.println("Calling saveIncident");
            try {
                serviceHelper.saveIncident(incident);
            } catch (Exception e) {
                e.printStackTrace();
            }
return  incidents;
        }

        public void update(Incident incident) {
            System.out.println("Calling updateIncident");
            try {
                serviceHelper.updateIncident(incident);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        public void delete(Incident incident) {
            System.out.println("Calling deleteIncident");
            serviceHelper.deleteIncident(incident);
        }

        public int incidentNumber() {
            System.out.println("Calling countIncidents");
            return serviceHelper.countIncidents();
        }

        public IncidentServiceImpl getServiceHelper() {
            return serviceHelper;
        }

        public void setServiceHelper(IncidentServiceImpl serviceHelper) {
            this.serviceHelper = serviceHelper;
        }

        public List<Incident> getIncidents() {


            return incidents;
        }

        public void setIncidents(List<Incident> incidents) {
            this.incidents = incidents;
        }

        public List<Incident> getRedflagIncidents() {
            return redflagIncidents;
        }

        public void setRedflagIncidents(List<Incident> redflagIncidents) {
            this.redflagIncidents = redflagIncidents;
        }

        public List<Incident> getInterventionIncidents() {
            return interventionIncidents;
        }

        public void setInterventionIncidents(List<Incident> interventionIncidents) {
            this.interventionIncidents = interventionIncidents;
        }

        public List<Type> getTypes() {
            return types;
        }

        public void setTypes(List<Type> types) {
            this.types = types;
        }

        public Incident getIncident() {
            return incident;
        }

        public void setIncident(Incident incident) {
            this.incident = incident;
        }

}

