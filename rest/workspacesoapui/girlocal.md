Create Local Git Repository
-----------------------------------------------------
o Create a local workspace
ex: /mnt/FDEV/workspacesoapui/axis2mavenprj04-addnumber

o Create a main Git repository vai --bare
git init --bare /mnt/FDATA/gitrepository/axis2/axis2mavenprj04-addnumber.git


o Configure repo
cd /mnt/FDATA/gitrepository/axis2/axis2mavenprj04-addnumber.git

Update file:
config

[core]
	repositoryformatversion = 0
	filemode = true
	bare = true
	editor = gedit
[user] 
	name = Philip Chauvet
	email = abc1260@outlook.com
[alias]
	st = status
	co = checkout
	br = branch
	up = rebase
	ci = commit



o Clone Local Repository (Checkout)
cd to desired workspace:
git clone /mnt/FDATA/gitrepository/axis2/axis2mavenprj04-addnumber.git

o Make changes to project

o Init working directory with change
-- Always init entire working directory
git add .
git add -A
git commit -m "Initial Axis2 Basic Project: Add Two Number Service"

git push origin master


o Review changes
git status



o Export repo

- Clone repo
- Create zip file of repo:
git archive HEAD --format=zip > archive.zip
- Create tar file of repo:
git archive HEAD | gzip > archive.tar.gz





