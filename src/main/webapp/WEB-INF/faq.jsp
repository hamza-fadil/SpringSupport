<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<head>
 	<title>Question fréquement posées</title>
	<jsp:include page="includes/head.jsp" />
</head>
<body>
<jsp:include page="includes/nav.jsp" />
	<br><br>

<div class="container">
     
        	<section id="content" role="main" class="container" style="position:relative;">
	
	   <h1 class="span12" style="color: #c00032;">F.A.Q.</h1>
       <p class="span12">F.A.Q. veut dire Frequently Asked Questions (Questions fréquentes posées par les utilisateurs). <br>
       Nous ajoutons régulièrement de nouvelles réponses à vos questions. </p>
      
	    <!-- Content column -->
    	<div class="span8_mr16" style="min-height:500px;padding-top:0px">
       	<div class="accordion">
       	<h3 class="accordion-trigger"><a href="#"><strong>Puis je accéder à ma boîte aux lettres de chez moi ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Oui.</p>

<p>Vous pouvez utiliser :</p>

<ul>
	<li>vos outils habituels;</li>
	<li>ou nos Webmails.</li>
</ul>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Puis je accéder à ma boîte aux lettres avec mon navigateur ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Oui, en utilisant RoundCube. En savoir plus sur nos Webmails.</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Je ne peux plus accéder à mes fichiers joints sous Outlook et Outlook Express.&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Allez dans le Menu Outils puis Options, puis onglet Sécurité.<br />
Vérifiez que l'option "<em>Ne pas autoriser l'ouverture des pièces jointes susceptibles de contenir un virus</em>" soit bien décochée.<br />
(Note : les menus peuvent être différents en fonction des versions de vos logiciels.)<br />
&nbsp;</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Comment empêcher Outlook Express et Outlook de scinder les messages volumineux ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<ol>
	<li>Dans le menu Outils, cliquez sur Comptes.</li>
	<li>Cliquez sur l'onglet Courrier.</li>
	<li>Dans la zone Compte, cliquez sur le compte que vous souhaitez modifier.</li>
	<li>Cliquez sur Propriétés, puis sur l'onglet Avancées.</li>
	<li>Désactivez la case à cocher "<em>Scinder les messages supérieurs à</em>".&nbsp;</li>
</ol>

<p>(Note : les menus peuvent être différents en fonction des versions de vos logiciels.)</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Comment cesser d'envoyer des courriers au format HTML ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p><strong>Thunderbird :</strong><br />
Localisation : Menu Outils, Paramètres de compte (choisir un compte), Rédaction et Adressage.<br />
Décochez "Rédiger les messages au format HTML"  .</p>

<p><strong>Outlook Express :&nbsp;</strong><br />
  Localisation : Menu Outils, Options, Onglet Envois.<br />
Cochez "<em>Format d'envoi du courrier en Texte brut</em>".</p>

<p><strong>Outlook :</strong><br />
  Localisation : Menu Outils, Options, onglet Envois.<br />
Cochez "<em>Format d'envoi du courrier en Texte brut</em>".</p>

<p>(Note : les menus peuvent être différents en fonction des versions de vos logiciels.)</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Comment passer de POP3 à IMAP sous Outlook et Outlook Express ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Dans la configuration de votre client de messagerie, ajoutez un nouveau compte de messagerie.<br />
Ce nouveau compte doit être en mode IMAP.<br />
<br />
Pour le reste de la configuration il doit être identique à la configuration du compte qui est actuellement définie en mode POP3.<br />
<br />
Pour optimiser la configuration de votre client de messagerie vous pouvez consulter notre rubrique Configuration préconisée.</p>

<p>Quand le nouveau compte IMAP est configuré, créez les dossiers que vous aviez dans votre arborescence POP3 dans votre arborescence IMAP.</p>

<p>Ensuite déplacer le contenu des dossiers POP3 vers les dossiers IMAP.<br />
<br />
<strong>ATTENTION : Ne pas déplacer de dossier; déplacez seulement les courriers !</strong></p>

<p>Après avoir déplacer les courriers du compte POP3 vers le compte IMAP, vous pouvez détruire le compte POP3 ou le désactiver.<br />
<br />
<strong>ATTENTION : Ne pas laisser actif le compte POP3 avec le compte IMAP !</strong></p>

<p>En cas de difficulté, vous pouvez contacter vos correspondants informatiques.</p>

<p>Quitte à changer, pouquoi ne pas passer sous Thunderbird ? <a href="https://www.mozilla.org/fr/thunderbird/" target="_blank">En savoir +</a></p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Le SPAM et le HAM c'est quoi ? Comment bien utiliser le courrier électronique ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Le mot SPAM provient de la contraction du nom d'une boîte de conserve de fabrication américaine contenant du jambon épicé (SPiced hAM). + d'infos sur <a href="https://fr.wikipedia.org/wiki/Spam#Origine_du_mot_anglais" target="_blank">Wikipédia</a>.   </p>

<p>Le SPAM désigne les courriers indésirables et le HAM les courriers légitimes.   <br />
Nous filtrons un très grand nombre de SPAM directement à le réception sur les serveurs. Il est difficile de vous débarasser de 100% des SPAM. Afin de tendre vers les 100% de suppression des SPAM au niveau du serveur nous avons mis en place pour les utilisateurs qui lisent leur boîte aux lettres en mode IMAP (lire : http://support.cgt.fr/html/services/messagerie/#pop3imap), un mécanisme d'apprentissage qui nous permet d'affiner les règles de blocage des SPAM.   <br />
Pour filtrer efficacement vos SPAM et HAM vous pouvez utiliser les mécanismes de filtrages proposés par votre client de messagerie.<br />
En complémenent, SI VOUS ETES EN IMAP et seulement dans ce cas (lire : http://support.cgt.fr/html/services/messagerie/#pop3imap), nous vous proposons de créer deux dossiers dans votre arborescence IMAP; le premier que vous nommez "spam" et le second "ham" (sans les guillemets).   Plusieurs fois par jour, les messages que vous déposez dans votre dossier "spam" sont automatiquement traités et intégrés dans les règles de filtrages du serveur. Après traitement, les messages déposés dans le dossier "spam" sont supprimés sans aucune possibilité de récupération. Il est impératif de ne déposer que ce qui est réellement du SPAM.   Les messages que vous déposez dans le dossier HAM indiquent qu'ils doivent être considérés par les règles de filtrages du serveur comme étant des NON SPAM.   <br />
En résumé, pour filtrer efficacement vos fichiers indésirables :</p>

<ul>
	<li>Si vous êtes en IMAP : créez un dossier : "spam" et copiez-y tous les spams que vous recevez.  (Ils seront traités et effacés de ce dossier)</li>
	<li>Si vous êtes en POP3 : envisagez sérieusement de passer en IMAP. En complément de la lutte anti-SPAM que nous menons,  utilisez les mécanismes de filtrages proposés par votre client de messagerie.  (Pour l'activation et la configuration contactez vos correspondants informatiques.)&nbsp;</li>
</ul>

<p>Informations en ligne :</p>

<p><a href="http://marc.herbert.free.fr/mail/" target="_blank">Courrier électronique : halte aux abus</a>, extrait du site de Marc Herbet, répondra à quelques unes de vos questions.<br />
<a href="http://www.cict.fr/net/ErreursMel.html" target="_blank">Les erreurs à ne pas commettre</a>, extrait du site du CCICT.</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Comment gérer la taille de ma boîte aux lettres électroniques sur le serveur de la CGT ?</strong></a></h3>
<div class="accordion-content">

<p>Vous avez reçu un courrier d'alerte indiquant que votre boîte aux lettres est pleine ?   Vous devez supprimer les messages de votre boîte aux lettres qui sont stockés sur le serveur.   </p>

<p>Quand votre boîte aux lettres est pleine (plus assez d'espace disque suffisant) vous ne  pouvez plus recevoir de message; vos expéditeurs reçoivent un message d'erreur leur  indiquant que votre boîte aux lettres est momentanément indisponible.   Les messages refusés devront être réexpédiés par vos expéditeurs après que vous ayez "nettoyé" votre boîte aux lettres.<br />
  Pour supprimer tout ou partie de vos courriers vous pouvez utiliser votre client de messagerie habituel ou les webmails que nous mettons à votre disposition.   </p>

<p><strong>Avec les webmails :&nbsp;</strong><br />
•&nbsp;&nbsp; &nbsp;<a href="http://webmail.cgt.fr/  " target="_blank">http://webmail.cgt.fr/  </a><br />
Après vous êtes authentifié, sélectionnez le (ou les) courrier(s) que vous souhaitez détruire et cliquez sur l'icone "Supprimer" (Rond rouge barré d'un trait rouge).<br />
Pour finir, cliquez sur le mot "Compacter" (en bas à gauche).&nbsp;</p>

<p><strong>  Avec votre client de messagerie :   </strong></p>

<p><strong>&gt;&gt; Si vous gérez votre compte en POP3 :&nbsp;</strong><br />
Pensez à vérifier dans la configuration de votre compte de messagerie  que vous ne conservez pas une copie des messages sur le serveur.   Si c'est le cas, désactivez cette conservation et réinterrogez votre  boîte aux lettres. Ceci permettra de vider réellement votre boîte sur le serveur.   Si l'option "conservez une copie ..." était cochée (sans doute êtes-vous plusieurs  à lire la même boîte), basculez du mode POP3 en mode IMAP.   </p>

<p>Si vous passez outre nos recommandations, activez au moins les options (si elles existent) :&nbsp;</p>

<ul>
	<li>"Conserver une copie des messages sur le serveur pendant 3 jours maximum"</li>
	<li>et  "Supprimer du serveur après suppression dans "Eléments supprimés".  (Cette dernière phrase est extraite de la configuration de Outlook.)  Les messages seront ainsi réellement supprimés quand vous viderez votre dossier "Eléments supprimés" ou "Corbeille".</li>
</ul>

<p>  OU (selon votre client de messagerie)</p>

<ul>
	<li>"Laissez les messages sur le serveur pendant 3 jours maximum"  </li>
	<li>et  "jusqu'à leur suppression"&nbsp;</li>
</ul>

<p>À défaut, votre boîte sur le serveur ne sera jamais vidée et rapidement vous ne  pourrez plus recevoir de nouveaux courriers.   </p>

<p><strong>Pour +&nbsp; d'informations :&nbsp;</strong><br />
Introduction sur la messagerie&nbsp;<br />
Mode POP3 / Mode IMAP&nbsp;<br />
Glossaire</p>

<p><br />
<strong>&gt;&gt;   Si vous gérez votre compte en IMAP :&nbsp;</strong><br />
Compactez (ou purgez) les dossiers.<br />
  Effacez vos courriers de la boîte de réception.  </p>

<p>ou </p>

<p>Transférez vos courriers de la boîte de réception vers un autre dossier.   <br />
Effacez vos courriers de vos dossiers au sein de l'arborescence IMAP.   <br />
Archivez les pièces jointes directement sur votre ordinateur, ne les stockez  pas sur le serveur.   Recompactez (ou purgez) les dossiers.   <br />
Compactez (ou purgez) les dossiers permet de supprimer réellement les courriers sur le serveur.   Vous pouvez configurer le compactage (ou la purge) automatique.&nbsp;</p>

<p>Attention : sous thunderbird, pour supprimer des dossiers il faut désactiver  l'option : "Le serveur supporte les dossiers contenant des sous dossiers et des messages.".   Pour la désactiver, allez dans les paramètres des comptes, ensuite paramètres du serveur et pour finir bouton "avancés…"   <br />
Décochez "Le serveur supporte les dossiers contenant des sous dossiers et des messages."&nbsp;<br />
&nbsp;</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Pourquoi MAILER-DAEMON m'écrit ?</strong></a></h3>
<div class="accordion-content">

<p>Si votre courrier ne peut pas être accepté par le serveur de messagerie MAILER-DAEMON vous enverra le message d'erreur qui devrait vous permettre d'ajuster ou de contacter votre destinataire pour lui faire part de l'erreur que vous rencontrez quand vous essayez de le joindre.</p>

<p>Les messages d'erreurs les plus courants :&nbsp;</p>

<ul>
	<li>User unknown : Utilisateur inconnu. Erreur dans l'adresse email (partie à gauche du caractère '@')</li>
	<li>Host unknown / Host not found : Machine inconnue. Erreur dans l'adresse email (partie à droite du caractère '@')</li>
	<li>Can't create output Quota exceeded : Boîte pleine, plus d'espace disque pour cette boîte aux lettres.</li>
</ul>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Quelle est la taille maximale autorisée d'un message en envoi ou en réception ?</strong></a></h3>
<div class="accordion-content">

<p>La taille maximale d'un message est de 15 Mo, pièces jointes incluses.&nbsp;</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>À combien de destinataires simultanés puis-je écrire avec les WebMail ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>100 destinataires simultanés.</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Utilisation de ANR-VPN (OpenVPN) sous windows 7 version PRO ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Cliquer avec le bouton droit de la souris sur l'executable "OpenVPNPortable".&nbsp;<br />
Sélectionner "Résoudre les problème de compatibilité".<br />
Sélectionner "Dépanner le programme".&nbsp;<br />
Cocher "Le programme fonctionnait dans les versions antérieures de Windows…".<br />
Cliquer sur le bouton "Suivant".<br />
Sélectionner le système d'exploitation par exemple "Windows XP".<br />
Cliquer sur le bouton "Suivant".<br />
Cliquer sur "Démarrer le programme".<br />
Il se peut qu'une fenêtre de dialogue vous demande de confirmer le lancement du programme.&nbsp;<br />
Après le lancement du programme, cliquer sur le bouton "Suivant".&nbsp;<br />
Si le programme fonctionne correctement, sélectionner "Oui, enregistrer ces paramètres…".<br />
Cliquer sur le bouton "Terminer".<br />
La prochaine fois vous pourrez directement démarrer OpenVPNPortable.</p>

</div>
<h3 class="accordion-trigger"><a href="#"><strong>Liste de diffusion : comment supprimer tous les abonnés d'un coup ?&nbsp;</strong></a></h3>
<div class="accordion-content">

<p>Vous pouvez utiliser l'interface <a href="http://sympa.cgt.fr/" target="_blank">http://sympa.cgt.fr/</a><br />
Après vous êtes authentifié comme propriétaire de la liste de diffusion, dans l'espace&nbsp;administration de votre liste, vous cliquez sur "Gérer les abonnés".<br />
Par défaut, cette action vous affichera 25 abonnés;&nbsp;pour tous les afficher, ajoutez à la fin de l'URL,<span style="color:#af0844"> /1/nb-abonné</span>, nb-abonné étant le nombre d'abonnés que vous voulez afficher.&nbsp;</p>

<p><strong>Exemple</strong> : Pour une liste se nommant <span style="color:#af0844">adherent-snj@cgt.fr</span>, l'affichage des abonnés affiche&nbsp;l'URL&nbsp;: https://sympa.cgt.fr/wws/review/adherent-snj, il vous suffira d'écrire :&nbsp;https://sympa.cgt.fr/wws/review/adherent-snj<span style="color:#af0844">/1/2000</span>, ce qui&nbsp;affichera 2 000 abonnés.&nbsp;</p></div>       	</div>
   	  </div>
	</section>
</div>

<jsp:include page="includes/footer.jsp" />

</body>
</html>