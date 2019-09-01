#!/bin/sh
# we use this shell script wrapper around the real gitweb.cgi since
# there appears to be no other way to pass arbitrary environment variables
# into the CGI process
GIT_EXEC_PATH=/usr/libexec/git-core GIT_DIR=/opt/was/git/NYSOHRulesRepository GITWEB_CONFIG=/opt/was/git/NYSOHRulesRepository/gitweb/gitweb_config.perl
export GIT_EXEC_PATH GIT_DIR GITWEB_CONFIG
exec /usr/share/gitweb/gitweb.cgi
