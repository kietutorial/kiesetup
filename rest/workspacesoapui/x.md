Create Local Git Repository
-----------------------------------------------------
o Create a main Git repository vai --bare
git init --bare /mnt/FDATA/gitrepository/axis2mavenprj02.git


o Configure repo
/mnt/FDATA/gitrepository/axis2mavenprj02.git

# Tell Git who you are
git config --global user.name "Philip Chauvet"
git config --global user.email pchauvet@gmail.com
# Select your favorite text editor
git config --global core.editor vim
# Add some SVN-like aliases
git config --global alias.st status
git config --global alias.co checkout
git config --global alias.br branch:q!
git config --global alias.up rebase
git config --global alias.ci commit

** I saw no changes, I create the .giconfig file and added:
.gitconfig

[user] 
name = Philip Chauvet
email = pchauvet@gmail.com
[alias]
st = status
co = checkout
br = branch
up = rebase
ci = commit
[core]
editor = vim


o Clone Local Repository

git clone /mnt/FDATA/gitrepository/axis2mavenprj02.git


o Init working directory with change
-- Always init entire working directory
git add .
git add -A
git commit -m "Initial checkin of 21-points application"

git push origin master


o Review changes
git status


o Copying complete external directory to working copy
-- Copy exteral to inside working copy
-- Run: git add .
-- Manually add directories not include
git add Readme.md
git add node_modules/
-- Get final status
git status

o Review log
git log
commit 79cf9682f71281cf896f8613eeca50cf8581c894
Author: Philip Chauvet <pchauvet@gmail.com>
Date:   Fri Sep 23 22:23:28 2016 -0400

    - Initialize project


Finally Push Changes To Repository
-----------------------------------------------
git push



Branching
------------------------------------------
-- View current branch
git branch


o From current working copy - master
-- create branch
git branch firstbranch02


o Checkout branch
git branch
* master
git checkout firstbranch02
git branch
* firstbranch02
  master


o Push branch
git push --set-upstream origin firstbranch02


o Checkout branch
- Version 1
git clone -b firstbranch02 /mnt/FDATA/gitrepository/axis2mavenprj02.git


- Version 2
git clone /mnt/FDATA/gitrepository/axis2mavenprj02.git 
checkout firstbranch02


o git rm
-- Remove files from the working tree and from the index

o Clear all changes
git reset --hard
git clean -fd


o Backout of previous commit
git reset --hard HEAD~1


o Show branch detail information
git show-branch 
[master] Rest master to include .* files and jphister files


git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/firstbranch02
  remotes/origin/jhispster_entities
  remotes/origin/jhispster_entities_v2
  remotes/origin/marterial_design_theme
  remotes/origin/master


git branch -r
  origin/HEAD -> origin/master
  origin/firstbranch02
  origin/jhispster_entities
  origin/jhispster_entities_v2
  origin/marterial_design_theme
  origin/master


git remote show origin
* remote origin
  Fetch URL: /mnt/FDATA/gitrepository/axis2mavenprj02.git
  Push  URL: /mnt/FDATA/gitrepository/axis2mavenprj02.git
  HEAD branch: master
  Remote branches:
    firstbranch02          tracked
    jhispster_entities     tracked
    jhispster_entities_v2  tracked
    marterial_design_theme tracked
    master                 tracked
  Local branch configured for 'git pull':
    master merges with remote master
  Local ref configured for 'git push':
    master pushes to master (up to date)


git ls-remote --heads origin
214535cc5c9a1df14c9d2f4db8f6af86743a62c9	refs/heads/firstbranch02
72d7ff15734b45d13c868d9d6d6f0a9380909c5e	refs/heads/jhispster_entities
9a8ac2a087227ef0ff69419da16d7fb22f44cc41	refs/heads/jhispster_entities_v2
d796dddbf2dc387d1b7edd9fb73239043e8fc589	refs/heads/marterial_design_theme
a593b5fa7c169bf1ab93121a3e3fe17f1ed9a89e	refs/heads/master






