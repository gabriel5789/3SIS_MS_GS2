import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
  http.get('http://localhost:8080/objetivos');
  http.get('http://localhost:8080/indicador/3.2.1');
  http.get('http://localhost:8080/ui/indicador/3.2.1');
  http.get('http://localhost:8080/ui/objetivos');
}


