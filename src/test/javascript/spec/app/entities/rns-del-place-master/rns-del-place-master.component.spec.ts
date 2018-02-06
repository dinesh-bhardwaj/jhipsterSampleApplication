/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_DEL_PLACE_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.component';
import { RNS_DEL_PLACE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.service';
import { RNS_DEL_PLACE_MASTER } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.model';

describe('Component Tests', () => {

    describe('RNS_DEL_PLACE_MASTER Management Component', () => {
        let comp: RNS_DEL_PLACE_MASTERComponent;
        let fixture: ComponentFixture<RNS_DEL_PLACE_MASTERComponent>;
        let service: RNS_DEL_PLACE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_DEL_PLACE_MASTERComponent],
                providers: [
                    RNS_DEL_PLACE_MASTERService
                ]
            })
            .overrideTemplate(RNS_DEL_PLACE_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_DEL_PLACE_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_DEL_PLACE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_DEL_PLACE_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_DEL_PLACE_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
