package com.example.hrapp.admin.tickets;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hrapp.models.Models;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.example.hrapp.models.Models.Tickets.DATE_CREATED;
import static com.example.hrapp.models.Models.Tickets.DATE_SOLVED;
import static com.example.hrapp.models.Models.Tickets.SOLVED;
import static com.example.hrapp.models.Models.Tickets.TICKET_CONTENT;
import static com.example.hrapp.models.Models.Tickets.TICKET_DB;
import static com.example.hrapp.models.Models.Tickets.TICKET_ID;
import static com.example.hrapp.models.Models.Tickets.TICKET_SEVERITY;
import static com.example.hrapp.models.Models.Tickets.USER_NAME;
import static com.example.hrapp.models.Models.Users.UID;

public class TicketsViewModel extends ViewModel {

    public TicketsViewModel() {

    }

    private LiveData<Models.Tickets> getTickets() {
        MutableLiveData<Models.Tickets> ticketsMutableLiveData = new MutableLiveData<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String fail = "Failed to get data";
        db.collection(TICKET_DB).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot qs = task.getResult();

                for (int i = 0; i <= qs.size() - 1; i++) {
                    Models.Tickets tickets = new Models.Tickets();
                    List<DocumentSnapshot> ds = qs.getDocuments();
                    String createdAt = "", solvedAt = "", userId = "", userName = "", content = "", severity = "", ticketId = "";
                    ArrayList<Models.Comments> comments;
                    boolean solved = false;

                    try {
                        createdAt = ds.get(i).get(DATE_CREATED).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        createdAt = fail;
                    }

                    try {
                        solvedAt = ds.get(i).get(DATE_SOLVED).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        solvedAt = fail;
                    }

                    try {
                        userId = ds.get(i).get(UID).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        userId = fail;
                    }

                    try {
                        userName = ds.get(i).get(USER_NAME).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        userName = fail;
                    }

                    try {
                        content = ds.get(i).get(TICKET_CONTENT).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        content = fail;
                    }

                    try {
                        severity = ds.get(i).get(TICKET_SEVERITY).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        severity = fail;
                    }

                    try {
                        ticketId = ds.get(i).get(TICKET_ID).toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        ticketId = fail;
                    }

                    try {
                        comments = (ArrayList<Models.Comments>) ds.get(i).get(DATE_CREATED);
                    } catch (Exception e) {
                        e.printStackTrace();
                        comments = null;
                    }

                    try {
                        solved = Boolean.parseBoolean(ds.get(i).get(SOLVED).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        solved = false;
                    }


                    tickets.setDateCreatedAt(createdAt);
                    tickets.setDateSolvedAt(solvedAt);
                    tickets.setSolved(solved);

                    tickets.setTicketComments(comments);
                    tickets.setUserId(userId);
                    tickets.setUserName(userName);

                    tickets.setTicketContent(content);
                    tickets.setTicketSeverity(severity);
                    tickets.setTicketId(ticketId);

                    ticketsMutableLiveData.setValue(tickets);
                }

            } else {
                Models.Tickets tickets = new Models.Tickets();

                tickets.setDateCreatedAt(fail);
                tickets.setDateSolvedAt(fail);
                tickets.setSolved(false);

                tickets.setTicketComments(null);
                tickets.setUserId(fail);
                tickets.setUserName(fail);

                tickets.setTicketContent(fail);
                tickets.setTicketSeverity(fail);
                tickets.setTicketId(fail);

                ticketsMutableLiveData.setValue(tickets);
            }
        });
        return ticketsMutableLiveData;
    }

    public LiveData<Models.Tickets> getTicketsList() {
        return getTickets();
    }

}
