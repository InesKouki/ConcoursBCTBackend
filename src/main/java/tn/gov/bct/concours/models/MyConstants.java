package tn.gov.bct.concours.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyConstants {

	private MyConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
	
public static final String FORMAT_DATE="dd/MM/yyyy HH:mm:ss";
	
	public static final String getFormattedDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(FORMAT_DATE);
	    return myDateObj.format(myFormatObj);
	}
	
	public static final String ADMIN_USERNAME="AdminBCT";
	public static final String SUCCESS_USER_TO_RH="Cet utilisateur est maintenant un responsable ressources humaines !";
	public static final String FAIL_USER_TO_RH="Échec du traitement";

	public static final String ROLE_NOT_FOUND="Error: Role is not found.";
	public static final String USERNAME_ALREADY_IN_USE="Cet identifiant est déjà utilisé!";
	public static final String EMAIL_ALREADY_IN_USE="Cette adresse mail est déjà utilisée!";
	public static final String EMAIL_DOESNT_EXIST="Cette adresse mail n'est pas inscrite sur la plateforme!";
	public static final String PASSWORD_RESET_SUCCESS="Mot de passe modifié avec succès !";
	public static final String CODE_SEND_SUCCESS="Un code de confirmation a été envoyé à votre adresse électronique !";
	public static final String FAIL_TO_SEND_MAIL="Échec de l'envoi du mail";
	public static final String SENDING_MAIL="Envoi du mail";
	public static final String MAIL_SENT="Mail envoyé avec succès";
	public static final String CODE_TYPE_CONFIRM="CONFIRM";
	public static final String CODE_TYPE_RESET="RESET";
	public static final String NUMBERS="0123456789";
	public static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final String MAIL_SUBJECT_CONFIRM="Inscription Site-Web Recrutement: Code de confirmation";
	public static final String MAIL_SUBJECT_RESET="Site-Web Recrutement: Réinitialisation de votre mot de passe";
	

	
	
	

}
