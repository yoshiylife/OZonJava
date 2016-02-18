#!/usr/local/bin/perl

umask 000;

$port = 5000;
$them = 'kazuto';

#
# Using on James Tappin <sjt@xun8.sr.bham.ac.uk>'s cgi_handlers.pl
#

####################################################################

# The CGI_HANDLERS deal with basic CGI POST or GET method request
# elements such as those delivered by an HTTPD form, i.e. a url
# encoded line of "=" separated key=value pairs separated by &'s

# Routines:
# get_request:	reads the request and returns both the raw and
#               processed version.
# url_decode:	URL decodes a string or array of strings
# html_header:	Transmits a HTML header back to the caller
# html_trailer: Transmits a HTML trailer back to the caller

# Author:
# 	James Tappin: sjt@xun8.sr.bham.ac.uk
#	School of Physics & Space Research University of Birmingham
#	Feb 1993.		

# Copyright & Disclaimer.
#	This set of routines may be freely distributed, modified and
#	used, provided this copyright & disclaimer remains intact.
#	This package is used at your own risk, if it does what you
#	want, good; if it doesn't, modify it or use something else--but
#	don't blame me. Support level = negligable (i.e. mail bugs but
#	not requests for extensions)

# Usage:
#	needs a 'require "cgi_handlers.pl";' line in the main script
#
#	&get_request;    will get the request and decode it into an
#			 indexed array %rqpairs, the raw request is in
#			 $request
#
#	... = &url_decode(LIST); will return a URL decoded version of
#			         the contents of LIST
#
#	&html_header(TITLE); 	will write to standard output an HTML
#				header (including the content-type
#				field) giving the document the title
#				specified by TITLE.
#
#	&html_trailer;		Writes a trailer to the html document
#				with the name of the script generating
#				it and the date (in UT).

sub get_request {

    # Subroutine get_request reads the POST or GET form request from STDIN
    # into the variable  $request, and then splits it into its
    # name=value pairs in the associative array %rqpairs.
    # The number of bytes is given in the environment variable
    # CONTENT_LENGTH which is automatically set by the request generator.

    # Encoded HEX values and spaces are decoded in the values at this
    # stage.

    # $request will contain the RAW request. N.B. spaces and other
    # special characters are not handler in the name field.

    if ($ENV{'REQUEST_METHOD'} eq "POST") {
        $length=$ENV{'CONTENT_LENGTH'};
        $sum=0;
	binmode STDIN;
        while ($sum < $length) {
	    $sum += read(STDIN, $request, $ENV{'CONTENT_LENGTH'},$sum);
        }
    } elsif ($ENV{'REQUEST_METHOD'} eq "GET" ) {
	$request = $ENV{'QUERY_STRING'};
    }

#$request = "text=%83e%83X%83g&.formId=OZCGI_TEST";

#    &url_decode ();
}

sub url_decode {

#	Decode a URL encoded string or array of strings 
#		+ -> space
#		%xx -> character xx

    $_ = $request;
    tr/+/ /;
    s/%(..)/pack("c",hex($1))/ge;
    $request= $_;
}

sub html_header {

    # Subroutine html_header sends to Standard Output the necessary
    # material to form an HHTML header for the document to be
    # returned, the single argument is the TITLE field.

    local($title) = @_;

    print "Content-type: text/html\n\n";
    print "<html>\n";
    print "<head>\n";
    print "<title>$title</title>\n";
    print "</head>\n<body>\n";
}

sub html_trailer {

    # subroutine html_trailer sends the trailing material to the HTML
    # on STDOUT.

#    local($sec, $min, $hour, $mday, $mon, $year, $wday, $yday, $isdst)
#	= gmtime;

#    local($mname) = ("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
#		     "Aug", "Sep", "Oct", "Nov", "Dec")[$mon];
#    local($dname) = ("Sun", "Mon", "Tue", "Wed", "Thu", "Fri",
#		     "Sat")[$wday]; 

#    print "<p>\nGenerated by: <var>$0</var><br>\n";
#    print "Date: $hour:$min:$sec UT on $dname $mday $mname $year.<p>\n";
    print "</body>\n";
    print "</html>\n";
}

sub html_result {
    &html_header("Thanks...");
    print "<pre>";
    print "$request";
    print "</pre>\n";
    &html_trailer;
}

get_request; # receiving data from WWW client

use Socket;

$AF_INET = &Socket'PF_INET;
$SOCK_STREAM = &Socket'SOCK_STREAM;

$SIG{'INT'} =  'dokill';
sub dokill {
    kill 9, $child if $child;
}

$sockaddr = 'S n a4 x8';

chop($hostname = `hostname`);

($name, $aliases, $proto) = getprotobyname ('tcp');
($name, $aliases, $port) = getservbyname ($port, 'tcp') 
    unless $port =~ /^\d+$/;;
($name, $aliases, $type, $len, $thisaddr) =
    gethostbyname ($hostname);
($name, $aliases, $type, $len, $thataddr) = 
    gethostbyname ($them);

$this = pack($sockaddr, $AF_INET, 0, $thisaddr);
$that = pack($sockaddr, $AF_INET, $port, $thataddr);

socket(S, $AF_INET, $SOCK_STREAM, $proto) || die "socket: $!";
bind (S, $this) || die "bind $!";
connect (S, $that) || die "connect $!";

binmode S;
binmode STDOUT;

select(S); $| = 1; select (STDOUT);

print S "$request";

while (<S>) {
    print "$_";
}

close(S);

# EOF

