# project-B-Open-Day-Application



If you want to merge your branch to master on remote, follow the below steps:

push your branch say 'br-1' to remote using git push origin br-1.

switch to master branch on your local repository using git checkout master.

update local master with remote master using git pull origin master.

merge br-1 into local master using git merge br-1. This may give you conflicts which need to be resolved and changes committed before moving further.

Once merge of br-1 to master on local is committed, push local master to remote master using git push origin master.
