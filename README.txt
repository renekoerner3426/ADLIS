1. Starting Services
service docker start
service ssh start

2. Create the .kube durectory
cd ~
mkdir .kube

3. Copy the kubeconfig file to .kube directory
cd ~
cp /home/project/README/20_Configs_Examples/Kube_Configs_GR1/f73-gr1-tg-8-kubeconfig_gke ~/.kube
cd .kube
mv f73-gr1-tg-8-kubeconfig_gke config

4. helm install
curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh

5. add bitnami repo
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update

6. initialize mongodb
cd ~/home/project
helm pull bitnami/mongodb
tar xvzf mongodb-10.5.1.tgz
cd mongodb
-> comment in and edit username, password, database in value.yaml to values saved in the secret for mongodb
helm install mongodb mongodb

6. initialize postgresql
cd ~/home/project
helm pull bitnami/postgresql
tar xvzf postgresql-10.2.5.tgz 
cd postgresql
-> comment in and edit username, password, database in value.yaml to values saved in the secret for postgresql
helm install postgresql postgresql

7. secrets
cd ~/home/project/hektor/ADLIS
kubectl apply -f mongoSecret.yaml
kubectl apply -f postgresqlSecret.yaml
kubectl apply -f adminSecret.yaml
kubectl create secret docker-registry dockreg --docker-server={dockerRepository} --docker-username={username} --docker-password={password}

8. backend  (lauff�higes image: adlbackend:)
cd ~/home/project/hektor/ADLIS/ADLBackend
docker build -t adlbackend:{version} .
docker tag adlbackend:{version} {dockerRepository}/adlbackend:{version}
docker push {dockerRepository}/adlbackend:{version}
kubectl apply -f adlbackend.yaml

9. account (lauff�higes image: account:)
cd ~/home/project/hektor/ADLIS/Account
docker build -t account:{version} .
docker tag account:{version} {dockerRepository}/account:{version}
docker push {dockerRepository}/account:{version}
kubectl apply -f account.yaml

10. ingress
cd ~/home/project/hektor/ADLIS
kubectl apply -f ingress.yaml

-> externe IP des ingress muss als environment Variable noch im Frontend eingepflegt werden

11. frontend (lauff�higes image: adlfrontend:)
-> externe IP des Ingress
-> ADLIS/ADLFrontend/src/environments/environment.prod.ts

cd ~/home/project/hektor/ADLIS/ADLFrontend
docker build -t frontend:{version} .
docker tag frontend:{version} {dockerRepository}/frontend:{version}
docker push {dockerRepository}/frontend:{version}
kubectl apply -f adlfrontend.yaml

wenn build fehlschl�gt, bitte eine mail an chris.froemling@volkswagen.de, da der tempor�re accesstoken zum group-ui-github veraltet sein k�nnte
ADLIS/ADLFrontend/.npmrc -> neuen accessToken einpflegen

12. recorder (lauff�higes image: adlrecorder:1.0)
cd ~/home/project/hektor/ADLIS/Recorder
docker build -t recorder:{version} .
docker tag recorder:{version} {dockerRepository}/recorder:{version}
docker push {dockerRepository}/recorder:{version}
kubectl apply -f adlrecorder.yaml
__________________________________________________

Sobald alles hochgefahren ist, steht die Benutzeroberfl�che zur Anwendung bereit.

Es werden Daten f�r folgende Fin's produziert, bei denen bei einer Registrierung Daten eingesehen werden k�nnen.

WVWZZZ1KZDP045466
WVWABC1JZ3W324523
WVWZKL5TG0W365465
WVWSDF1CP3W456646
WVWDTK1JZ3W198834
WVWZOB1JZ3W553532
WVWDRH1JZ3W164931
WVWDUT1JZ3W897456
WVWJUL1JZ3W123568
WVWSER1JZ3W786541




