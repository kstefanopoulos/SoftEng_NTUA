# **Εννιαίο Έγγραφο Ανάλυσης Απαιτήσεων και Τεχνικών Προδιαγραφών**  

## Ομάδα : :cherries: **Little** **Cherries**  :cherries:
## **Little** **Cherries** **Project** 



## **Μέλη** :

Όνοματεπώνυμο  | ΑΜ |  
-------------- | --- | 
*Τελάλη* *Ειρήνη* | 03113009 |
*Ξεζωνάκη* *Δανάη*|  03113065 |  
*Στεφανόπουλος Κοσμάς*|  03113098 | 
*Τασσοπούλου* *Βασιλική*|  03113003  | 
*Στρατή* *Φωτεινή* |  03113001| 


*******


### **Kατάλογος Περιεχομένων**

### 1. Εισαγωγή   
+ 1.1. Σκοπός του εγγράφου
+ 1.2. Δήλωση του πεδίου εφαρμογής
+ 1.3. Επιχειρησιακός Στόχος
    + 1.3.1 Βιωσιμότητα Πλατφόρμας

### 2. Πολιτική Πλατφόρμας
+ 2.1. Κατηγορίες χρηστών    
+ 2.2. Ορισμός κλάσεων χρηστών    
+ 2.3. Διάγραμμα κλάσεων χρηστών 
+ 2.4. Περιγραφή επιτρεπτών ενεργειών χρηστών
+ 2.5. Παραδοχές

### 3.  Αλληλεπίδραση Συστήματος με Χρήστες
+ 3.1. Περιγραφή σεναρίων χρήσης    
+ 3.2. Ακολουθιακά Διαγράμματα Σεναρίων Χρήσης
+ 3.3. Wireframes

### 4. Αρχιτεκτονική Συστήματος
+ 4.1. Τεχνολογίες
+ 4.2. Εσωτερικά Υποσυστήματα
    + 4.2.1. Serves
    + 4.2.2. Σχεδιασμός Βάσης Δεδομένων
        + 4.2.2.1. Περιγραφή Βάσης
        + 4.2.2.2. E-R Διαγράμματα
    + 4.2.3. Κλάσεις
    + 4.2.4. UML Διαγράμματα Κλάσεων
+ 4.3. Το πρόσθετο Module
+ 4.4. Εξωτερικά Υποσυστήματα

### 5. Ορισμός μη λειτουργικών απαιτήσεων 
+ 5.1. Διαθεσιμότητα - Ανάνηψη από καταστροφές
+ 5.2. Ασφάλεια - Ακεραιότητα
+ 5.3. Ευελιξία - Επεκτασιμότητα
+ 5.4. Απόδοση - Αποκρισιμότητα
+ 5.5. Υποστήριξη διεθνών προτύπων


******

<h> **1. Εισαγωγή** </h> 

<h> **1.1 Σκοπός του Εγγράφου** </h> 
<p> Στο παρόν έγγραφο παρουσιάζονται και αναλύονται οι Απαιτήσεις Συστήματος και οι Τεχνικές Προδιαγραφές της Διαδικτυακής Πλατφόρμας Little Cherries.
 Αρχικά, παρουσιάζεται η πολιτική της πλατφόρμας Little Cherries, δηλαδή οι απαιτήσεις που έχουν οριστεί, και στη συνέχεια αναλύεται η αρχιτεκτονική του Συστήματος.</p>

<h> **1.2. Δήλωση του πεδίου Εφαρμογής** </h> 
<p>H Ηλεκτρονική Πλατφόρμα Εύρεσης Δραστηριοτήτων (ΕΔ) Little Cherries έχει ως βασική λειτουργία την αγορά εισιτητηρίων για κάποια εκδήλωση από κάποιον γονέα για το παιδί 
    του καθώς και την δημοσίευση εκδήλωσεων από έναν Πάροχο. Το λογισμικό θα χρησιμοποιείται αποκλειστικά από Παρόχους και Γονείς. Η ιστοσελίδα της πλατφόρμας θα είναι
    φυσικά προσβάσιμη και για τους Ανώνυμους Χρήστες χωρίς όμως αυτοί να είναι ικανοί να κάνουν οποιοδήποτε χειρισμό για δημοσίοποίηση εκδήλωσης ή για αγορά 
    εισιτηρίου.</p>  
   <p>Τα βασικά αιτήματα των χρηστών διαχωρίζονται ανάλογα με την κατηγορία αυτών. Για παράδειγμα, οι Γονείς έχουν κύριο αίτημα να μπορούν να αγοράζουν 
    εισιτήρια για οποιαδήποτε δραστηριότητα θέλουν. Από την άλλη πλευρά, οι Πάροχοι έχουν ως πρωταρχικό αίτημα να μπορούν να δημοσιοποιήσουν την εκδήλωση τους 
    ή και ακόμα να την προωθήσουν.Και στα δύο είδη χρηστών ικανοποιείται το αίτημα δημιουργίας και επεξεργασίας του προφίλ.</p>
    
<h> **1.3 Eπιχειρησιακός Στόχος** </h> 


<h> **3. Αλληλεπίδραση Συστήματος με Χρήστες** </h>

<h>**3.3. Wireframes**</h>
<p>Στη συνέχεια, παρατίθενται τα Wireframes μέσω των οποίων αλληλεπιδρούν οι Χρήστες με την πλατφόρμα Little Cherries.</p>

<h>**Home**</h>
<p> <a href="url"><img src="Wireframes/Home_page.png" align="middle" height="400" width="400" ></a></p>

<h>**About Us**</h>
<p> <a href="url"><img src="Wireframes/Aboutus_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Contact Us**</h>
<p> <a href="url"><img src="Wireframes/Contact_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Events**</h>
<p> <a href="url"><img src="Wireframes/Events_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Single Event Page**</h>
<p> <a href="url"><img src="Wireframes/SingleEvent_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Registration**</h>
<p> <a href="url"><img src="Wireframes/Registration.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Add an Admin**</h>
<p> <a href="url"><img src="Wireframes/Add_Admin_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Admin Login**</h>
<p> <a href="url"><img src="Wireframes/Admin_login_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Admin Profile**</h>
<p> <a href="url"><img src="Wireframes/Admin_profile_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Admin Views Events**</h>
<p> <a href="url"><img src="Wireframes/View_events_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Admin Views Admins**</h>
<p> <a href="url"><img src="Wireframes/View_admins_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Company Registration**</h>
<p> <a href="url"><img src="Wireframes/Company_registration.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Company Profile**</h>
<p> <a href="url"><img src="Wireframes/Company_profile.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Company Profile Edit**</h>
<p> <a href="url"><img src="Wireframes/Company_profile_edit.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Company's Events**</h>
<p> <a href="url"><img src="Wireframes/Company_events_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Event Creation**</h>
<p> <a href="url"><img src="Wireframes/Event_creation_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Company Views Events' Statistics**</h>
<p> <a href="url"><img src="Wireframes/Company_view_statisticts_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Parent Registration**</h>
<p> <a href="url"><img src="Wireframes/ParentRegistration.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Parent Profile**</h>
<p> <a href="url"><img src="Wireframes/Parent_profile.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Parent Profile Edit**</h>
<p> <a href="url"><img src="Wireframes/Parent_profile_edit.jpg" align="middle" height="400" width="400" ></a></p>

<h>**Search Events**</h>
<p> <a href="url"><img src="Wireframes/Search_page1.png" align="middle" height="400" width="400" ></a></p>

<h>**Parent Loads Credits**</h>
<p> <a href="url"><img src="Wireframes/Loadcredits_page.png" align="middle" height="400" width="400" ></a></p>

<h>**Reservation**</h>
<p> <a href="url"><img src="Wireframes/Reservation_page.png" align="middle" height="400" width="400" ></a></p>

<h>**After Reservation Failure**</h>
<p> <a href="url"><img src="Wireframes/After_reservation_failure.png" align="middle" height="400" width="400" ></a></p>

<h>**After Reservation Success**</h>
<p> <a href="url"><img src="Wireframes/After_reservation_success.png" align="middle" height="400" width="400" ></a></p>


##  5. Ορισμός μη λειτουργικών απαιτήσεων

<h> **5.1. Διαθεσιμότητα - Ανάνηψη από καταστροφές** </h>
    <p> H διαθεσιμότητα του συστήματος μπορεί να διασφαλιστεί με τακτικό backup της βάσης, σε συνδυασμό με τη δημιουργία δομών για redeployment, σε περίπτωση απροόπτου. 
        Επίσης, καλή πρακτική είναι η χρήση standby spare servers(ιδανικά σε cloud), που θα εξασφαλίσουν τη διαθεσιμότητα των υπηρεσιών μας κατά το recovery phase.
    </p>
    
<h> **5.2. Ασφάλεια - Ακεραιότητα** </h>
    <p> Η ασφάλεια των παρεχόμενων υπηρεσιών επιτυγχάνεται χάρη στην ταυτοποίηση των χρηστών, προκειμένου να εκτελέσουν τις διάφορες λειτουργίες, καθώς και με τη δυνατότητα του admin να μειώνει δικαιώματα ή να μπλοκάρει λογαριασμούς όταν αυτοί παραβιάζουν την πολιτική ορθής χρήσης της πλατφόρμας.
        Επίσης, η χρήση του πρωτοκόλλου HTTPS για όλες τις σελίδες διασφαλίζει την ακεραιότητα της υπηρεσίας από εξωτερικές κακόβουλες επιθέσεις.
    </p>
    
<h> **5.3. Ευελιξία - Επεκτασιμότητα** </h>
    <p> Η πλατφόρμα παρέχει την απαραίτητη ευελιξία κατά τη χρήση της, καθώς είναι screen responsive και μπορεί να χρησιμοποιηθεί με τον ίδιο τρόπο από Desktop, Tablet ή Mobile συσκευές.
        Επίσης, υπάρχει η δυνατότητα επέκτασης της λειτουργικότητας του συστήματος σε μελλοντικές εκδόσεις, με την προσθήκη χαρακτηριστικών όπως Σύγκριση Υπηρεσιών, Επι πληρωμή διαφήμιση παρόχων ή Εκπτωτικές τιμές για μαζική αγορά εισιτηρίων.
    </p>
    
<h> **5.4. Απόδοση - Αποκρισιμότητα** </h>
    <p> Είναι σημαντικό το σύστημα να είναι άμεσα αποκρίσιμο, προκειμένου να διασφαλιστεί το καλό user experience του χρήση.
        Επιπλέον έμφαση θα πρέπει να δοθεί σε ορισμένες λειτουργίες, όπως το atomicity των κρατήσεων εισιτηρίων ή οι τραπεζικές συναλλαγές.
        Παρ' όλα αυτά, καθώς δεν πρόκειται για ένα σύστημα πραγματικού χρόνου (π.χ. ιατρικές εφαρμογές) είναι ανεκτή η εισαγωγή κάποιας καθυστέρησης στην απόκρισή του, ειδικά σε λειτουργίες που με μεγάλες απαιτήσεις σε επεξεργαστική ισχύ, όπως είναι το uploading και η επεξεργασία των φωτογραφιών.
    </p>
    
<h> **5.5. Υποστήριξη διεθνών προτύπων** </h>
    <p> Το σύστημα θα πρέπει να συμμορφώνεται με τα διεθνή πρότυπα, ειδικά σε ότι αφορά την αλληλεπίδρασή του με άλλα, ήδη υπάρχοντα, συστήματα, όπως η υπηρεσία χαρτών και τα banking transactions.
        Επίσης, το deployment του θα γίνεται με τη χρήση ευρέως διαδεδομένων εργαλείων λογισμικού, ενώ είναι χρήσιμο η βάση να υποστηρίζει μαζική εισαγωγή - εξαγωγή δεδομένων, σε κάποιο international format, όπως το .csv.
    </p>
    
