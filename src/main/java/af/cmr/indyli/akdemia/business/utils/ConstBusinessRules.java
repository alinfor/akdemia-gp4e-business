package af.cmr.indyli.akdemia.business.utils;

/**
 * This class contains constant business rules for the Akdemia application.
 * These rules are represented as static final strings with unique identifiers
 * (RG01, RG02, etc.) and describe various constraints and validations
 * applicable to different aspects of the system.
 */
public class ConstBusinessRules {

	public static final String RG01 = "RG01 : Les dates doivent être au format jj/MM/aaaa.";
	public static final String RG02 = "RG02 : Les adresses emails doivent être uniques.";
	public static final String RG03 = "RG03 : Le code de session doit être unique.";
	public static final String RG04 = "RG04 : Le titre de la formation doit être unique.";
	public static final String RG05 = "RG05 : Le titre d’un thème est unique.";
	public static final String RG06 = "RG06 : Le titre d’un sous thème est unique.";
	public static final String RG07 = "RG07 : Un particulier ne s’inscrit pas à une session intra.";
	public static final String RG08 = "RG08 : Le mot de passe des utilisateurs doit être à partir de 04 caractères.";
	public static final String RG09 = "RG09 : Aucune date session ne doit être nulle.";
	public static final String RG10 = "RG10 : Le formateur ne doit pas être remplacé à moins de 15 jours de la date de début de la formation";
	public static final String RG11 = "RG11 : Un sous thème ayant au moins une formation ne doit pas être supprimé.";
	public static final String RG12 = "RG12 : Aucune session ne peut être planifiée dans un délai de moins de 3 mois (90 jours).";
	public static final String RG13 = "RG13 : Lancer la procédure d’annulation si le quota de participants n’est pas atteint 15 jours avant le début.";
	public static final String RG14 = "RG14 : Une session inter devra être annulée si le nombre de participants est inférieur à 3 ou 4.";
	public static final String RG15 = "RG15 : Un thême ayant au moins un sous-thème ne doit pas être supprimé.";
	public static final String RG16 = "RG16 : Un participant étant inscrit au moins à une session ne doit pas être supprimé du système.";
	public static final String RG19 = "RG19 : Une compagnie ayant au moins une session commandée ne doit pas être supprimé du système.";
	public static final String RG20 = "RG20 : Un participant ne peut être ajouté à la même session plus d’une fois.";

}
